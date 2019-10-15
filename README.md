# News Mediator
Simple proxy between NewsApi and simple front in Angular.
Angular Material Table is used in front.

Project is divided for 2 modules: back and front stuff.

While executing mvn install on root project, it will compile both, and copy binaries from frontend 'dist' directory to backend 'target' directory.

To run, please use docker-compose file which is in newsmediator-service/src/main/docker.
Then access URL: http://your_IP_addres:8081

Currenct state: from Angular app user sees only 'pl' 'technology' articles.
By accesing http://your_IP_addres:8081/news/{country}/{category}/ user can see produced JSON transformed from NewsApi, by given country an category.
