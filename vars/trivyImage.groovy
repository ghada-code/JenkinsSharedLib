def call() {
    sh 'sudo trivy image ghadah/app:latest > trivyimage.txt'
}