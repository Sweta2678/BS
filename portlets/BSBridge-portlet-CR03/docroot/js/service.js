Liferay.Service.register("Liferay.Service.bsservices", "com.ihg.brandstandards.db.service", "BSBridge-portlet");

Liferay.Service.registerClass(
	Liferay.Service.bsservices, "JobQueue",
	{
		addJobQueue: true,
		updateJobQueue: true,
		updateJobQueueStatus: true,
		deleteJobQueue: true,
		getAllJobQueues: true,
		getJobQueuesExceptFullManuals: true,
		getJobQueuesByOwnerAndType: true,
		getJobQueuesByOwnerTypeAndStatus: true,
		getJobQueuesByType: true,
		getJobQueuesByTypeAndStatus: true,
		getJobQueuesByOwner: true,
		getUniqueJobQueTypes: true
	}
);