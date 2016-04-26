PROJECT = 'Jenot'

BRANCHES = ['master', 'dev']

STEPS = [
		'assemble'         : 'assemble',
		'build'            : 'build',
		'check'            : 'check',
		'cobertura'        : 'cobertura',
		'groovydoc'        : 'groovydoc',
		'dependencyUpdates': 'dependencyUpdates'
]

BRANCHES.each { String branch ->
	createJobPipeline(branch)
}

def createJobPipeline(String branch) {
	STEPS.each { name, command ->
		createJob(PROJECT as String, branch as String, name as String, command as String)
	}
}

/**
 *
 * @param projectName The project's name.
 * @param branchName The branch being checked out.
 * @param jobName The name for the job.
 * @param command The Gradle command run on job execution.
 */
def createJob(String projectName, String branchName, String jobName, String command) {
	job(projectName + branchName.capitalize() + '-' + jobName) {
		logRotator(-1, 20, -1, 20)
		scm {
			git {
				remote {
					name('origin')
					url('https://github.com/EightBitBoy/Jenot.git')
				}
				branch(branchName)
			}
		}
		H/5 * * * *
		steps {
			shell('bash gradlew ' + command)
		}
	}
}
