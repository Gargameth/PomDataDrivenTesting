pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'rm -rf projectroot'
                sh 'git clone https://github.com/Gargameth/PomDataDrivenTesting.git projectroot'
                sh 'cd projectroot'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw clean compile'
            }
        }
    }
}
