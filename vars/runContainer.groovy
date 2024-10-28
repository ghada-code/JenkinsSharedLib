def call(){
    sh "sudo docker run -d --name App -p 3000:3000 ghadah/app:latest"
}