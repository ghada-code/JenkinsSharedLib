def call() {
    withSonarQubeEnv('SonarServer') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=App -Dsonar.projectKey=App '''
    }
}