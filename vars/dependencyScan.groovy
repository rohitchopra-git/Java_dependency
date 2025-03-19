def call() {
    stage('Dependency Scanning') {
        sh 'mvn org.owasp:dependency-check-maven:check || true'
    }
}
