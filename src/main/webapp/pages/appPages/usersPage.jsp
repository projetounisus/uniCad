<div ng-controller="usersCtrl">
	<div class = container>
		<div class="row">
			<div ng-repeat="user in users" class="mdl-card mdl-card__supporting-text mdl-shadow--2dp box">
				<div>
					<div class="row-list-title">
						<h4>{{user.completeName}}</h4> 
					</div>
					
					<div class="row-list-buttons">
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">create</i></button>
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">delete</i></button>
					</div>
				</div>
			</div>
		</div>
	</div>>
	<button class="mdl-button mdl-button--fab"><i class="material-icons">add_circle</i></button>
</div>