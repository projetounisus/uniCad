<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-15"%>
<div ng-controller="medicCtrl">
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
				<span class="mdl-button__ripple-container"><span class="mdl-ripple"></span>
			</span>
	</button>

  	<div class="modal fade" id="create-form" role="dialog">
	    <div class="modal-dialog">
	    
	      <div class="modal-content">
	        
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Novo usuário</h4>
	        </div>
	        
	        <div class="modal-body">
				<div class="container" style="width:100%">
					<div class="row"><h6 class="col-md-12">Dados pessoais</h6></div>
					<div class="row">
						<div class="col-md-12"><input type="text" placeholder="Nome completo" ng-model="currentUser.completeName"/></div>	
					</div>
					<div class="row">
						<div class="col-md-4"><input type="text" placeholder="cpf" ng-model="currentUser.cpf"/></div>
						<div class="col-md-4"><input type="date" ng-model="currentUser.birthDate"/></div>
						<div class="col-md-4"><input type="text" placeholder="gênero" ng-model="currentUser.genre"/></div>
					</div>

					<div class="row"><h6 class="col-md-12">Moradia</h6></div>
					<div class="row">								
						<div class="col-xs-12"><input type="text" placeholder="rua" ng-model="currentUser.address.street"/></div>
					</div>
					<div class="row">
						<div class="col-xs-4"><input type="text" placeholder="país" ng-model="currentUser.address.country"/></div>
						<div class="col-xs-4"><input type="text" placeholder="estado" ng-model="currentUser.address.uf"/></div>
						<div class="col-xs-4"><input type="text" placeholder="Cidade" ng-model="currentUser.address.city"/></div>
					</div>
					<div class="row">
						<div class="col-xs-8"><input type="text" placeholder="Bairro" ng-model="currentUser.address.neighborhood"/></div>
						<div class="col-xs-4"><input type="text" placeholder="numero" ng-model="currentUser.address.number"/></div>
					</div>
					
					<div class="row"><h6 class="col-md-12">Dados de login</h6></div>
						<div class="row">
							<div class="col-xs-6">
								<input type="text" placeholder="login" ng-model="currentUser.login.userName"/>
							</div>
							<div class="col-xs-6">
								<input type="text" placeholder="senha" ng-model="currentUser.login.userPassword"/>
						</div>
					</div>
					
					<div class="row"> <h6 class="col-md-12">Dados Profissionais</h6> </div>
					<div class="row">
						<div class="col-xs-4">
							<input type="text" placeholder="CRM" ng-model="currentUser.crm"/>
						</div>
						
						<div class="col-xs-4">
							<button class="btn btn-parimary" data-target="#list-spciality-form" data-toggle="modal" style="width:100%">especialidades</button>
						</div>
						
						<div class="col-xs-4">
							<select ng-options="atendimentUnityOption.name for atendimentUnityOption in atendimentUnities" ng-model="currentUser.atendimentUnity">
								<option value="">Unidade de atendimento</option>
							</select>
						</div>	
						
					</div>
				</div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default btn-primary" data-dismiss="modal" ng-click="createOrAdd(currentUser)">Criar</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	        </div>
	      
	      </div>
	    </div>
 	</div>
	
	<div class="modal fade" id="list-spciality-form" role="dialog">
		<div class="modal-dialog">
		
			<div class="modal-content">
			
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Especialidades</h4>
				</div>

				<div class="modal-body">
					<div class="container" style="width:100%">
						<div class="row">
							<div class="col-xs-6">
								<button class="btn" style="width:100%" ng-click="addUserSpecialityBuffer(selectedEspeciality)">Adicionar</button>
							</div>

							<div class="col-xs-6">
								<select ng-options="selectedEspeciality.name for selectedEspeciality in specialities" ng-model="selectedEspeciality">
									<option value="">Especialidade</option>
								</select>
							</div>
						</div>
						
						<div class="row">	
							<div style="height:250px; width:100%;">
								<div style="overflow-x:hidden;overflow-y:auto;max-height:100%; width:100%;">
									<div class="container" style="width:100%; padding:25px;">
										<div class="row " ng-repeat="currentSpeciality in specialitiesBuffer">
											<div style="width:100%">
												<div class="row-list-title">
													<span class="list-card-title">{{currentSpeciality.name}}</span> 
												</div>
												
												<div class="row-list-buttons">
													<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">delete</i></button>
												</div>
											</div>
										</div>
									</div>
								</ul>
							</div>
						</div>
						
					</div>
				</div>
				
				<div class="modal-footer">
					  <button type="button" class="btn btn-default btn-primary" data-dismiss="modal" ng-click="confirmUserSpecialities(specialitiesBuffer)">OK</button>
					  <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancelUserSpecialities()">Cancelar</button>
				</div>
			</div>
	
		</div>
	</div>

</div>