@Library('depend_lib') _

pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        BRANCH_NAME = 'main' 
        REPO_URL = 'https://github.com/snaatak-Zero-Downtime-Crew/salary-api.git'
        SLACK_CHANNEL = "jenkins"
        EMAIL_RECIPIENTS = "rohit.chopra@mygurukulam.co"
    }

    stages {
        stage('Clone Repository') {
            steps {
                script {
                    gitClone(env.BRANCH_NAME, env.REPO_URL, 'gitR')
                }
            }
        }

        stage('Dependency Scanning') {
            steps {
                script {
                    dependencyScan()
                }
            }
        }

      /*  stage('Publish Report') {
            steps {
                script {
                    publishReport()
                }
            }
        } */

        stage('notify') {
            steps {
                script {
                    notify(env.JOB_NAME, currentBuild.number.toString(), env.BUILD_URL)
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
            archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
        }

        success {
            echo "✅ Build was successful!"
        }

        failure {
            echo "❌ Build failed!"
        }
    }
}
