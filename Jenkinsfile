pipeline {
    agent any
    tools {
        maven 'maven-3.9.11'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Echo build number') {
            steps {
                script {
                    def gitCommit = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
                    currentBuild.displayName = "${gitCommit}"
                }
                echo "Build number is ${currentBuild.number}"
                echo "The commit that relates to the build is ${currentBuild.displayName}"
            }
        }
    }
}