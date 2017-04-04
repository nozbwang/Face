<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>纳灵科技</title>
	<%@ include file="common/common.jsp"%>
	<link rel="stylesheet" href="/css/main.css" type="text/css"  />
</head>

<body>
	<c:set var="pageType" value="index" scope="page"/>
	<%@include file="common/header.jsp" %>

	<div id="teaser">
		<div class="wrap">
			<div id="image"></div>
			<img src=""/>
			
			<div class="box">
				<h2>物联网(Internet of things)</h2>
				<p>物联网正在从根本上改变企业的运营模式以及人们与现实世界的互动方式。包括汽车、传送带甚至农作物在内的几乎所有事物都实现了互连互通，因此企业运用所产生的数据进行全面的业务转型已是当务之急。</p>
			</div>
		</div>
	</div>

	<div id="bar">
		<div class="wrap">
			<span class="step"><a>1</a> data collection</span>
			<span class="step"><a>2</a> behavior analysis</span>
			<span class="step"><a>3</a> equipment evolution</span>
		</div>
	</div>

	<div class="wrap">
		<div class="col">
			<h3><span class="red"> 数据采集</span></h3>
			<p>	&nbsp;&nbsp;&nbsp;&nbsp;物联网规模庞杂，而且不断变化。设备与人员之间的数以十亿计的互动，所产生的物联网数据不仅规模庞杂，而且不断变化。预先编写的程序已经难以胜任对物联网数据的分析任务。传统系统无法通过将物联网数据与天气和社交之类的非结构化数据结合起来，获得有意义的洞察。</br>
			</p>
		</div>
		<div class="col">
			<h3><span class="red"> 人机交互</span></h3>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;而认知型物联网可以让所有类型的数据发挥最大作用。事实上，它可以选择数据源，并确定要留意的模式和关系。它使用机器学习和高级处理能力来组织数据，形成洞察。认知型物联网还可以通过学习进行自我纠正和自我适应，不断进化，不断改进。</p>
		</div>
		<div class="col last">
			<h3>通过纳灵物联网， <span class="red">您可以</span></h3>	
			<p >			更好的管理智能设备,更好的了解用户，以便提供更好的服务。物联网正在逐渐改变我们所熟悉的生活方式。我们的未来有无限种可能，我们都被邀请来享受这场通往更光明世界的美好旅程!
			</p>
		</div>
	</div>
		
	<%@include file="common/footer.jsp" %>
</body>
</html>