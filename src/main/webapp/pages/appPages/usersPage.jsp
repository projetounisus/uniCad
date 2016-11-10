<div ng-controller="usersCtrl">
	<div class = container>
		<div class="row">
				
			<div ng-repeat="user in users" class="mdl-card mdl-card__supporting-text mdl-shadow--2dp list-card">
				<div>
					<div class="row-list-title">
						<span class="list-card-title">{{user.completeName}}</span> 
					</div>
					
					<div class="row-list-buttons">
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">create</i></button>
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" ng-click="delete(user)"><i class="material-icons">delete</i></button>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	<button class="mdl-button mdl-button--fab mdl-button--colored mdl-shadow--4dp mdl-color--accent add-bean" id="add" data-target="#create-form" data-toggle="modal">
            <i class="material-icons" role="presentation">add</i>
            <span class="visuallyhidden">Add</span>
  	<span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></button>

  	<div class="modal fade" id="create-form" role="dialog">
	    <div class="modal-dialog">
	    
	      <div class="modal-content">
	        
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Novo usuário</h4>
	        </div>
	        
	        <div class="modal-body">
	    		<input type="text" placeholder="Nome completo" ng-model="currentUser.completeName"/>
	    		<input type="text" placeholder="cpf" ng-model="currentUser.cpf"/>
	    		<input type="date" ng-model="currentUser.birthDate"/>

	    		<input type="text" placeholder="login" ng-model="currentUser.login.userName"/>
	    		<input type="text" placeholder="senha" ng-model="currentUser.login.userPassword"/>

    			<input type="text" placeholder="país" ng-model="currentUser.address.country"/>
	    		<input type="text" placeholder="estado" ng-model="currentUser.address.uf"/>
	    		<input type="text" placeholder="Cidade" ng-model="currentUser.address.city"/>
	    		<input type="text" placeholder="Bairro" ng-model="currentUser.address.neighborhood"/>
	    		<input type="text" placeholder="rua" ng-model="currentUser.address.street"/>
	    		<input type="text" placeholder="numero" ng-model="currentUser.address.number"/>

	    		<input type="hidden" placeholder="Nome completo" ng-model="currentUser.address.country" value="Brasil"/>
	        </div>
	        
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default btn-primary" data-dismiss="modal" ng-click="createOrAdd(currentUser)">Criar</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	        </div>
	      
	      </div>
	    </div>
 	</div>
</div>