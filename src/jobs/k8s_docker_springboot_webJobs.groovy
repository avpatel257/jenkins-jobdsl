import com.dslexample.builder.PipelineJobBuilder

List developers = ['dev1@example.com', 'dev2@example.com']

new PipelineJobBuilder()
    .repoName("k8s-docker-springboot-web")
    .gitBranch("main")
    .emails(developers)
    .build(this)