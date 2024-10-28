def call() {
    sh 'trivy image ghadah/aop:latest > trivyimage.txt'
}