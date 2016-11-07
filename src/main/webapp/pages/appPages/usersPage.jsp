<div ng-controller="usersCtrl">
	<div ng-repeat="user in users" class="box">
		<h2>{{user.completeName}}</h2>
		<span>
			{{user.cns}}
		</span>
	</div>
</div>