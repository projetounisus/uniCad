<div ng-controller="usersCtrl">
	<div class = container>
		<div class="row">
			<div ng-repeat="user in users" class="mdl-card mdl-card__supporting-text mdl-shadow--2dp box">
				<div class="col-sm-6">
					<h4>{{user.completeName}}</h4> 
				</div>
				
				<div class="col-sm-6">
					<button class="mdl-button"><i class="material-icons">edit</i></button>
				</div>
			</div>
		</div>
	</div>>
	<button class="mdl-button mdl-button--fab"><i class="material-icons">add</i></button>
</div>