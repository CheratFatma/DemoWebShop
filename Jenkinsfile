pipeline {

    agent any

    tools {
        jdk 'JDK8'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Tests Selenium') {
            steps {
                sh 'mvn test -Dbrowser=chrome'
            }
        }
    }

    post {

        always {

            // Rapport Surefire / JUnit
            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            // Rapport Allure
            allure([
                includeProperties: false,
                results: [
                    [path: 'target/allure-results']
                ]
            ])

            // Archive les rapports Surefire
            archiveArtifacts(
                artifacts: 'target/surefire-reports/**/*',
                allowEmptyArchive: true
            )
        }

        success {
            echo 'Pipeline terminée avec succès'
        }

        failure {
            echo 'Les tests Selenium ont échoué'
        }
    }
}