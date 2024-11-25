def call() {
    sh 'sudo trivy image --scanners vuln ghadah/app:latest > trivyimage.txt'
}
