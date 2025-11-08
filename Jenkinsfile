pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3.9.11"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                // git 'https://github.com/???.git'
                // Run Maven on a Unix agent.
                sh "mvn clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
//                     junit '/var/jenkins_home/workspace/build_dummy-greeting/target/surefire-reports/TEST-org.eugerman.greeting.GreetingApplicationTests.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
    }
}
