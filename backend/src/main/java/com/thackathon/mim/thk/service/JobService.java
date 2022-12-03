package com.thackathon.mim.thk.service;

import com.querydsl.core.BooleanBuilder;
import com.thackathon.mim.thk.entity.Job;
import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.entity.QJob;
import com.thackathon.mim.thk.enums.JobTypeEnum;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.JobRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final PersonService personService;

    public JobService(@NonNull final JobRepository jobRepository,
                      @NonNull final PersonService personService){
        this.jobRepository = jobRepository;
        this.personService = personService;
    }
    public Job getJob(Long id) {
        return jobRepository.findOne(QJob.job.id.eq(id)).orElseThrow(() -> new CustomException("Job with id not found!"));
    }

    public List<Job> findJobs(Pageable page, Long person_id, String jobType) {
        Person person = personService.getPerson(person_id);
        BooleanBuilder builder = new BooleanBuilder();
        if (JobTypeEnum.FULLTIME.value().equals(jobType)){
            builder.and(QJob.job.jobType.eq(JobTypeEnum.FULLTIME.value()));
        } else if (JobTypeEnum.PARTTIME.value().equals(jobType)) {
            builder.and(QJob.job.jobType.eq(JobTypeEnum.PARTTIME.value()));
        } else if (JobTypeEnum.INTERNSHIP.value().equals(jobType)) {
            builder.and(QJob.job.jobType.eq(JobTypeEnum.INTERNSHIP.value()));
        } else if (JobTypeEnum.SESSIONAL_WORK.value().equals(jobType)) {
            builder.and(QJob.job.jobType.eq(JobTypeEnum.SESSIONAL_WORK.value()));
        } else if (jobType != null){
            throw new CustomException("Wrong job type!");
        }
        person.getSkills().forEach(skillsEnum -> {
            builder.and(QJob.job.name.contains(skillsEnum.value().toLowerCase(Locale.ROOT))
                    .or(QJob.job.description.contains(skillsEnum.value().toLowerCase(Locale.ROOT))));
        });
        return jobRepository.findAll(builder, page).getContent();
    }
}
