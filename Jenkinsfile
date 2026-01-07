
pipeline {
    agent any

    tools {
        maven 'Maven3'   // MUST match Global Tool Configuration name
    }

    parameters {
        string(name: 'TagName', defaultValue: 'TC_001', description: 'Cucumber tag')
        string(name: 'deviceName', defaultValue: 'emulator-5554', description: 'USB Device ID')
        string(name: 'platformVersion', defaultValue: '16', description: 'Android Version')
    }

    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat """
                mvn test ^
                -Dcucumber.filter.tags=@%TagName% ^
                -DdeviceName=%deviceName% ^
                -DplatformVersion=%platformVersion%
                """
            }
        }

        stage('Deliver') {
            steps {
                echo 'Test Execution Completed'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: '**/target/**/*.html', fingerprint: true
        }

        success {
            emailext(
                mimeType: 'text/html',
                subject: "✅ Appium Test Passed - Build #${BUILD_NUMBER}",
                body: """
                <h2>Appium Automation Execution - SUCCESS</h2>
                <p><b>Job:</b> ${JOB_NAME}</p>
                <p><b>Build:</b> ${BUILD_NUMBER}</p>
                <p><b>Device:</b> ${params.deviceName}</p>
                <p><b>Tag:</b> ${params.TagName}</p>
                <p><b>Status:</b> PASSED</p>
                <p><a href="${BUILD_URL}">View Jenkins Build</a></p>
                """,
                to: "admiredolly@gmail.com"
            )
        }

        failure {
            emailext(
                mimeType: 'text/html',
                subject: "❌ Appium Test Failed - Build #${BUILD_NUMBER}",
                body: """
                <h2>Appium Automation Execution - FAILURE</h2>
                <p><b>Job:</b> ${JOB_NAME}</p>
                <p><b>Build:</b> ${BUILD_NUMBER}</p>
                <p><b>Device:</b> ${params.deviceName}</p>
                <p><b>Tag:</b> ${params.TagName}</p>
                <p><b>Status:</b> FAILED</p>
                <p><a href="${BUILD_URL}">Check Logs</a></p>
                """,
                to: "admiredolly@gmail.com"
            )
        }
    }
}