Insert into person (id, name, lastname, email, password, type) values (1, 'Janko', 'Hrasko', 'hrasko.janko@gmail.com', 'hackathon', 'Expert');
Insert into person (id, name, lastname, email, password, type) values (2, 'Fridrich', 'Hrasko', 'hrasko.fridrich@gmail.com', 'hackathon', 'Expert');
Insert into person (id, name, lastname, email, password, type) values (3, 'Peter', 'Fazulka', 'fazulka.peter@gmail.com', 'hackathon', 'Študent');
Insert into person (id, name, lastname, email, password, type) values (4, 'Juraj', 'Mrkvicka', 'mrkvicka.juraj@gmail.com', 'hackathon', 'Pedagóg');
Insert into person (id, name, lastname, email, password, type) values (5, 'Gejza', 'Imre', 'imre.gejza@gmail.com', 'hackathon', 'Firma');

Insert into post (id, name, content, image_url, likes, created_date, visibility, publisher_id) values (1,'New verzia angular','','https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Angular_full_color_logo.svg/2048px-Angular_full_color_logo.svg.png',4526,'2022-10-08',false,1);
Insert into post (id, name, content, image_url, likes, created_date, visibility, publisher_id) values (2,'Spring boot s december update & angular, java','','https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/800px-Spring_Framework_Logo_2018.svg.png',56123,'2022-11-08',true,1);
Insert into post (id, name, content, image_url, likes, created_date, visibility, publisher_id) values (3,'JDK 19 - Java ...','','https://azpanel.azilen.com/uploads/everything_must_know_spring_boot_application_scratch_12_8c4e62d4fe.jpg',12056,'2022-11-20',false,2);
Insert into post (id, name, content, image_url, likes, created_date, visibility, publisher_id) values (4,'How to Monitor Container Memory and CPU Usage in Docker Desktop','','https://www.docker.com/wp-content/uploads/2022/03/vertical-logo-monochromatic.png',2123,'2022-12-01',true,2);
Insert into post (id, name, content, image_url, likes, created_date, visibility, publisher_id) values (5,'Need help with Quartz jobs - University research','','https://upload.wikimedia.org/wikipedia/commons/5/54/TUKE_logo.jpg',20,'2022-09-14',true,4);

Insert into person_skills (person_id, skills) values (1 , 'ANGULAR');
Insert into person_skills (person_id, skills) values (1 , 'JAVA');
Insert into person_skills (person_id, skills) values (1 , 'SPRINGBOOT');
Insert into person_skills (person_id, skills) values (2 , 'SPRINGBOOT');
Insert into person_skills (person_id, skills) values (2 , 'DOCKER');
Insert into person_skills (person_id, skills) values (2 , 'GIT');
Insert into person_skills (person_id, skills) values (3 , 'C');
Insert into person_skills (person_id, skills) values (3 , 'GIT');
Insert into person_skills (person_id, skills) values (4 , 'DOCKER');

Insert into job (id, name, description, job_type, company_contact_person_id) values (1, 'Junior Java developer', 'java, spring', 'polovičný pracovný úväzok', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (2, 'Medior Java developer', 'oracle', 'plný pracovný úväzok', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (3, 'Senior Java developer', 'java, hibernate, git, ...', 'plný pracovný úväzok', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (4, 'Devops developer', 'lens, git, devops, docker', 'stáž', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (5, 'FE developer', 'react, react native, js, ..', 'polovičný pracovný úväzok', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (6, 'Angular developer', 'angular, git, ide, ...', 'plný pracovný úväzok', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (7, 'Analytik', 'Jira, Teams, Enterprise architect, ...', 'plný pracovný úväzok', 5);
Insert into job (id, name, description, job_type, company_contact_person_id) values (8, 'Junior Angular developer', 'angular, ide, chut pracovat', 'brigáda', 5);