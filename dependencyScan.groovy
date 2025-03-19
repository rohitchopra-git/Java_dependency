def call() {
    stage('Dependency Scanning') {
        steps {
            sh 'mvn org.owasp:dependency-check-maven:check'
        }
    }
}
