/*package com.TesteDP.TesteDp.business;

import com.TesteDP.TesteDp.infrastructure.entitys.Usuario;
import com.TesteDP.TesteDp.infrastructure.repository.JobRepository;

public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobResponse create(JobRequest request) {


        Usuario admin = SecurityUtils.getAuthenticatedUser();
        if (admin.getRole() != Role.ADMIN) {
            throw new BusinessException("Apenas admin pode criar vagas");
        }


        Job job = new Job();
        job.setTitle(request.title());
        job.setDescription(request.description());
        job.setStatus(JobStatus.OPEN);
        job.setCreatedBy(admin);
        // parte que salva no banco essa parte e importante mano
        Job saved = jobRepository.save(job);

        return new JobResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getStatus().name()
        );
  }
}
*/