<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ include file = "include/header.jsp"%>

<style>
	
	.btn {
		width : 10%;
	}
</style>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<input type = "button" value = "버튼" class = "btn-lg btn-success">

<button type="button" class="btn btn-block btn-danger btn-xs">Danger</button>

<a class="btn btn-block btn-social btn-github">
<i class="fa fa-github"></i> Sign in with GitHub
</a>

<div class="box box-danger">
<div class="box-header with-border">
<h3 class="box-title">Donut Chart</h3>
<div class="box-tools pull-right">
<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
</button>
<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
</div>
</div>
<div class="box-body">
<canvas id="pieChart" style="height: 209px; width: 418px;" height="209" width="418"></canvas>
</div>

</div>




<div class="col-xs-12">

<div class="box box-primary">
<div class="box-header with-border">
<i class="fa fa-bar-chart-o"></i>
<h3 class="box-title">Interactive Area Chart</h3>
<div class="box-tools pull-right">
Real time
<div class="btn-group" id="realtime" data-toggle="btn-toggle">
<button type="button" class="btn btn-default btn-xs active" data-toggle="on">On</button>
<button type="button" class="btn btn-default btn-xs" data-toggle="off">Off</button>
</div>
</div>
</div>
<div class="box-body">
<div id="interactive" style="height: 300px; padding: 0px; position: relative;"><canvas class="flot-base" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 885px; height: 300px;" width="885" height="300"></canvas><div class="flot-text" style="position: absolute; inset: 0px; font-size: smaller; color: rgb(84, 84, 84);"><div class="flot-x-axis flot-x1-axis xAxis x1Axis" style="position: absolute; inset: 0px;"><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 21px; text-align: center;">0</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 104px; text-align: center;">10</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 190px; text-align: center;">20</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 276px; text-align: center;">30</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 362px; text-align: center;">40</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 449px; text-align: center;">50</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 535px; text-align: center;">60</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 621px; text-align: center;">70</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 707px; text-align: center;">80</div><div class="flot-tick-label tickLabel" style="position: absolute; max-width: 80px; top: 282px; left: 793px; text-align: center;">90</div></div><div class="flot-y-axis flot-y1-axis yAxis y1Axis" style="position: absolute; inset: 0px;"><div class="flot-tick-label tickLabel" style="position: absolute; top: 269px; left: 13px; text-align: right;">0</div><div class="flot-tick-label tickLabel" style="position: absolute; top: 215px; left: 7px; text-align: right;">20</div><div class="flot-tick-label tickLabel" style="position: absolute; top: 161px; left: 7px; text-align: right;">40</div><div class="flot-tick-label tickLabel" style="position: absolute; top: 108px; left: 7px; text-align: right;">60</div><div class="flot-tick-label tickLabel" style="position: absolute; top: 54px; left: 7px; text-align: right;">80</div><div class="flot-tick-label tickLabel" style="position: absolute; top: 1px; left: 1px; text-align: right;">100</div></div></div><canvas class="flot-overlay" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 885px; height: 300px;" width="885" height="300"></canvas></div>
</div>

</div>

</div>



<div class="col-md-4">

<div class="box box-widget widget-user-2">

<div class="widget-user-header bg-yellow">
<div class="widget-user-image">
<img class="img-circle" src="../dist/img/user7-128x128.jpg" alt="User Avatar">
</div>

<h3 class="widget-user-username">Nadia Carmichael</h3>
<h5 class="widget-user-desc">Lead Developer</h5>
</div>
<div class="box-footer no-padding">
<ul class="nav nav-stacked">
<li><a href="#">Projects <span class="pull-right badge bg-blue">31</span></a></li>
<li><a href="#">Tasks <span class="pull-right badge bg-aqua">5</span></a></li>
<li><a href="#">Completed Projects <span class="pull-right badge bg-green">12</span></a></li>
<li><a href="#">Followers <span class="pull-right badge bg-red">842</span></a></li>
</ul>
</div>
</div>

</div>



<%@ include file = "include/footer.jsp" %>
