repoBase = "https://github.com/avpatel257"
repoName = "nordic-apis-2019"

def createCIJob(jobName) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoBase + "/" + repoName + ".git")
                        }
                        branches('main')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}

def buildPipelineJobs() {
    def ciName = repoName + "_ci"
    def prBuilderName = repoName + "_pr_builder"
    createCIJob(ciName)
    createCIJob(prBuilderName)
}

buildPipelineJobs()
