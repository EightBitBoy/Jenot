PROJECT = 'Jenot'

BRANCHES = ['master', 'dev']

Map<String, String> STEPS = [
		'Assemble': 'assemble'
]

branches.each { String branch ->
	createJobPipeline(branch)
}

def createJobPipeline(String branch) {
	STEPS.each { String name, String command ->
		createJob(PROJECT, branch, name, command)
	}
}

/**
 *
 * @param branch The branch being checked out.
 * @param name The name for the job.
 * @param command The gradle command run on job execution.
 */
def createJob(String project, String branchName, String jobName, String command) {
	job(project + '-' + branch + '-' + jobName) {
		logRotator(-1, 20, -1, 20)
	}
	scm {
		git {
			remote {
				name('origin')
				url('https://github.com/EightBitBoy/Jenot.git')
			}
			branch(branchName)
		}
	}
	steps {
		gradle(command)
	}
}
