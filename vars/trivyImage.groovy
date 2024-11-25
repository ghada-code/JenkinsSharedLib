def call() {
    sh 'sudo trivy image --scanners vuln --timeout 20m ghadah/app:latest > trivyimage.txt'
}
