pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'rm -rf projectroot'
                sh 'git clone https://github.com/Gargameth/PomDataDrivenTesting.git pojectroot'
                sh 'cd projectroot'
            }
        }
        stage('Test') {
            steps {
                sh 'mvnw test'
            }
        }
    }
}