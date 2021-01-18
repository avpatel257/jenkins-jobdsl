package com.dslexample.builder

import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

@Builder(builderStrategy = SimpleStrategy, prefix = '')
class PipelineJobBuilder {
    String repoBase = 'https://github.com/avpatel257'
    String repoName
    String description
    String gitBranch = 'master'
    List<String> emails = []

    Job build(DslFactory dslFactory) {
        dslFactory.pipelineJob(repoName) {
            definition {
                cpsScm {
                    scm {
                        git {
                            remote {
                                url(repoBase + "/" + repoName + ".git")
                            }
                            branches(gitBranch)
                            extensions {
                                cleanBeforeCheckout()
                            }
                        }
                    }
                    scriptPath("Jenkinsfile")
                    publishers {
                        if (emails) {
                            mailer emails.join(' ')
                        }
                    }
                }
            }
        }
    }
}
