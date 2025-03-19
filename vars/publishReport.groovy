def call() {
    stage('Publish Report') {
        steps {
            publishHTML([
                allowMissing: false, 
                alwaysLinkToLastBuild: true, 
                keepAll: false, 
                reportDir: 'target', 
                reportFiles: 'dependency-check-report.html', 
                reportName: 'Dependency Check Report'
            ])
        }
    }
}
