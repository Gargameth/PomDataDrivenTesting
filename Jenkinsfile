pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'rm -rf projectroot'
                sh 'git clone https://github.com/Gargameth/PomDataDrivenTesting.git projectroot'
                sh 'cd projectroot'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -Dtest=CreateIssueTests test'
            }
        }
    }
}
