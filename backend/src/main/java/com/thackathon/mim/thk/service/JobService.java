package com.thackathon.mim.thk.service;

import com.querydsl.core.BooleanBuilder;
import com.thackathon.mim.thk.entity.Job;
import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.entity.PersonPostLikes;
import com.thackathon.mim.thk.entity.Post;
import com.thackathon.mim.thk.entity.QJob;
import com.thackathon.mim.thk.entity.QPerson;
import com.thackathon.mim.thk.entity.QPersonPostLikes;
import com.thackathon.mim.thk.entity.QPost;
import com.thackathon.mim.thk.enums.JobTypeEnum;
import com.thackathon.mim.thk.enums.SkillsEnum;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.JobRepository;
import com.thackathon.mim.thk.repository.PersonPostLikesRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final PersonService personService;
    private final PersonPostLikesRepository personPostLikesRepository;

    private final PostService postService;

    private static final String DELIMITER = " ";

    public JobService(@NonNull final JobRepository jobRepository,
                      @NonNull final PersonService personService,
                      @NonNull final PersonPostLikesRepository personPostLikesRepository,
                      @NonNull final PostService postService){
        this.jobRepository = jobRepository;
        this.personService = personService;
        this.personPostLikesRepository = personPostLikesRepository;
        this.postService = postService;
    }
    public Job getJob(Long id) {
        return jobRepository.findOne(QJob.job.id.eq(id)).orElseThrow(() -> new CustomException("Job with id not found!"));
    }

    public List<Job> findJobs(Pageable page, Long person_id, String jobType) {
        Person person = personService.getPerson(person_id);

        /** Vyhlada dany typ aky preferuje ak vobec preferuje nejaky **/
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

        /** extrahujeme technologie z jeho postov ktore sa mu pacili za poslednych 30 dni**/
        HashMap<SkillsEnum, Long> extractedSkillsFromPosts = new HashMap<>();
        List<PersonPostLikes> ppl = personPostLikesRepository
                .findAll(QPersonPostLikes.personPostLikes.person.id.eq(person_id).and(QPersonPostLikes.personPostLikes.createdDate.goe(LocalDate.now().minusDays(30))), Pageable.unpaged())
                .getContent();
        List<Post> likedPostsByUser = new ArrayList<>();
        ppl.forEach(pl -> likedPostsByUser.add(pl.getPost()));

        likedPostsByUser.forEach(lp -> {
            for (SkillsEnum value : SkillsEnum.values()) {
                if (lp.getName().contains(DELIMITER + value.value().toLowerCase(Locale.ROOT))
                        || lp.getName().toLowerCase(Locale.ROOT).equals(DELIMITER + value.value().toLowerCase(Locale.ROOT))){
                    if (extractedSkillsFromPosts.containsKey(value)){
                        extractedSkillsFromPosts.put(value, extractedSkillsFromPosts.get(value) + 1);
                    } else {
                        extractedSkillsFromPosts.put(value, 1L);
                    }
                }
                if (lp.getContent().contains(DELIMITER + value.value().toLowerCase(Locale.ROOT))
                        || lp.getContent().toLowerCase(Locale.ROOT).contains(DELIMITER + value.value().toLowerCase(Locale.ROOT))){
                    if (extractedSkillsFromPosts.containsKey(value)){
                        extractedSkillsFromPosts.put(value, extractedSkillsFromPosts.get(value) + 1);
                    } else {
                        extractedSkillsFromPosts.put(value, 1L);
                    }
                }
            }
        });

        /** prepocitat ake technologie sa najviac spominali a zistit tym interest **/
        SkillsEnum highestValue = Collections.max(extractedSkillsFromPosts.entrySet(), (entry1, entry2) -> entry1.getValue().intValue() - entry2.getValue().intValue()).getKey();

        Long maxInterest = extractedSkillsFromPosts.get(highestValue);

        person.getSkills().forEach(skillsEnum -> extractedSkillsFromPosts.put(skillsEnum, maxInterest));
        HashMap<SkillsEnum, Long> sortedSkills = sortByValue(extractedSkillsFromPosts);
        person.getSkills().forEach(skillsEnum -> {
            builder.and(QJob.job.name.contains(skillsEnum.value().toLowerCase(Locale.ROOT))
                    .or(QJob.job.description.contains(skillsEnum.value().toLowerCase(Locale.ROOT))));
        });
        return jobRepository.findAll(builder, page).getContent();
    }

    public static HashMap<SkillsEnum, Long> sortByValue(HashMap<SkillsEnum, Long> hm) {
        List<Map.Entry<SkillsEnum, Long> > list =
                new LinkedList<Map.Entry<SkillsEnum, Long> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<SkillsEnum, Long> >() {
            public int compare(Map.Entry<SkillsEnum, Long> o1,
                               Map.Entry<SkillsEnum, Long> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<SkillsEnum, Long> temp = new LinkedHashMap<SkillsEnum, Long>();
        for (Map.Entry<SkillsEnum, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
