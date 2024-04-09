pipeline {
    agent any
    tools {
        jdk 'Java21'
        maven 'Maven3'
    }   
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials-id')
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'docker build -t tejaswi251100/sixfortyfive .'
            }
        }
        stage('Login to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials-id', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                }
            }
        }
        stage('Push Docker image') {
            steps {
                sh 'docker push tejaswi251100/tejaswidevi'
            }
        }
        stage('Deployment') {
            steps {
                sh 'kubectl rollout restart deployment/a'
            }
        }
    }
}
