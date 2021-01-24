import com.dslexample.builder.PipelineJobBuilder

List developers = ['dev1@example.com', 'dev2@example.com']

new PipelineJobBuilder()
    .repoName("nordic-apis-2019")
    .gitBranch("master")
    .emails(developers)
    .build(this)
