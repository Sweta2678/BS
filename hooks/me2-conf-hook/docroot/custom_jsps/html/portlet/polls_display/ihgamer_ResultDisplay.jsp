
<%
	NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
	NumberFormat percentFormat = NumberFormat
			.getPercentInstance(locale);
%>

<table border="0" cellpadding="1" cellspacing="0" width="100%">
	<tr class="portlet-section-header results-header"
		style="font-weight: bold;">
		<td>%</td>
		<td colspan="4"><liferay-ui:message key="votes" /></td>
	</tr>

	<%
		int totalVotes = question.getVotesCount();

		for (int i = 0; i < choices.size(); i++) {
			PollsChoice choice = (PollsChoice) choices.get(i);

			choice = choice.toEscapedModel();

			int choiceVotes = choice.getVotesCount();

			String className = "portlet-section-body results-row";
			String classHoverName = "portlet-section-body-hover results-row hover";

			if (MathUtil.isEven(i)) {
				className = "portlet-section-alternate results-row alt";
				classHoverName = "portlet-section-alternate-hover results-row alt hover";
			}

			double votesPercent = 0.0;

			if (totalVotes > 0) {
				votesPercent = (double) choiceVotes / totalVotes;
			}

			int votesPixelWidth = 35;

			if (windowState.equals(WindowState.MAXIMIZED)) {
				votesPixelWidth = 100;
			}

			int votesPercentWidth = (int) Math.floor(votesPercent
					* votesPixelWidth);
	%>

	<tr class="<%=className%>" 
		onMouseEnter="this.className = '<%=classHoverName%>';"
		onMouseLeave="this.className = '<%=className%>';">
		<td><%=percentFormat.format(votesPercent)%></td>
		<td><%=numberFormat.format(choiceVotes)%></td>
		<td></td>
		<td><strong><%=choice.getName()%>.</strong></td>
		<td><%=choice.getDescription(locale)%></td>
	</tr>

	<%
		}
	%>

</table>
<!-- <p class="fLeft">
	<input type="submit" class="poll-go" value="Submit" disabled="disabled">
</p> -->