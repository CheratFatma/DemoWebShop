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
                sh 'mvn test'
            }
        }
    }

    post {

        always {

            // Rapport JUnit / Surefire
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
        }

        success {
            echo 'Pipeline terminée avec succès'
        }

        failure {
            echo 'Les tests ont échoué'
        }
    }
}