job('Vanila Node App') {
    scm {
        git('https://github.com/mbiskho/jenkins-phi.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('mbiskho')
            node / gitConfigEmail('khomeini.bisma@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {

        shell("cd demo-app/")
        shell("npm install")
    }
}
