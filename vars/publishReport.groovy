def call() {
    stage('Publish Report') {
        script {
            echo "Publishing Dependency Check Report..."
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
