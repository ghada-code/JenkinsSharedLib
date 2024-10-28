def call() {
    sh 'trivy image ghadah/app:latest > trivyimage.txt'
}