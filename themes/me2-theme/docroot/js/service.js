Liferay.Service.register("Liferay.Service.Asset", "com.liferay.portlet.asset.service");

Liferay.Service.registerClass(
	Liferay.Service.Asset, "AssetCategory",
	{
		addCategory: true,
		deleteCategory: true,
		getCategories: true,
		getCategory: true,
		getChildCategories: true,
		getVocabularyCategories: true,
		getVocabularyRootCategories: true,
		search: true,
		updateCategory: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Asset, "AssetCategoryProperty",
	{
		addCategoryProperty: true,
		deleteCategoryProperty: true,
		getCategoryProperties: true,
		getCategoryPropertyValues: true,
		updateCategoryProperty: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Asset, "AssetEntry",
	{
		getCompanyEntries: true,
		getCompanyEntriesCount: true,
		getCompanyEntriesRSS: true,
		getCompanyEntryDisplays: true,
		getEntries: true,
		getEntriesCount: true,
		getEntriesRSS: true,
		getEntry: true,
		incrementViewCounter: true,
		searchEntryDisplays: true,
		searchEntryDisplaysCount: true,
		updateEntry: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Asset, "AssetTag",
	{
		addTag: true,
		deleteTag: true,
		getGroupTags: true,
		getTag: true,
		getTags: true,
		mergeTags: true,
		search: true,
		updateTag: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Asset, "AssetTagProperty",
	{
		addTagProperty: true,
		deleteTagProperty: true,
		getTagProperties: true,
		getTagPropertyValues: true,
		updateTagProperty: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Asset, "AssetVocabulary",
	{
		addVocabulary: true,
		deleteVocabulary: true,
		getCompanyVocabularies: true,
		getGroupsVocabularies: true,
		getGroupVocabularies: true,
		getVocabulary: true,
		updateVocabulary: true
	}
);