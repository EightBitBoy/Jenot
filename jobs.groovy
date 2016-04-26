PROJECT = 'Jenot'

BRANCHES = ['master', 'dev']

Map<String, String> STEPS = [
		'Assemble': 'assemble'
]

BRANCHES.each { String branch ->
	createJobPipeline(this, branch)
}

def createJobPipeline(env, String branch) {
	env.STEPS.each { String name, String command ->
		createJob(env.PROJECT, branch, name, command)
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
