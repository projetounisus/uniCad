<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8"%>
<div ng-controller="medicCtrl">
	<div class="main-container">
	<div class = "container">
		<div class="mdl-layout__tab-panel is-active">
			<div class="row">
		
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--4dp section-main-page">
					<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
						<h4 class="card-title">Pacientes</h4>
						
						<div class="row">
							<div class="col-md-3" style="float:left;">
								<div style="padding: 10px; margin: 10px;">
									<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" id="add" data-target="#create-form" data-toggle="modal"><i class="material-icons">add</i></button>Adicionar
								</div>
							</div>
						</div>

						<div class="container mdl-card-container">
							<div class="row">
								<div class="col-md-12">
									<table id="table-data" data-height="100%" class="table table-hover">
										<thead>
											<tr>
												<th>
													Nome
												</th>

												<th>
													Rede de clínicas
												</th>

												<th>
												</th>
											</tr>
										</thead>

										<tbody>
											<tr ng-repeat="current in unities">
												<td>{{current.name}}</td>
												<td>{{current.cns}}</td>
												<td>
													<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" style="float:right;"><i class="material-icons" ng-click="setCurrentUser(current)" data-target="#create-form" data-toggle="modal">create</i></button>
													<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" style="float:right;"><i class="material-icons" ng-click="delete(current)">delete</i></button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</section>

			</div>
		</div>
	</div>
	
  	<div class="modal fade" id="create-form" role="dialog">
	    <div class="modal-dialog">
	    
	      <div class="modal-content">
	        
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Novo paciente</h4>
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

					<div class="row"><h6 class="col-md-12">Dados médicos</h6></div>
					<div class="row">
						<div class="col-md-3">
							<input type="text" placeholder="CNS" ng-model="currentUser.cns"/>
						</div>
						<div class="col-md-3">
							<input type="text" placeholder="altura" ng-model="currentUser.currentMedicStatus.height"/>
						</div>
						<div class="col-md-3">
							<input type="text" placeholder="peso" ng-model="currentUser.currentMedicStatus.weight"/>
						</div>
						<div class="col-md-3">
							<input type="text" placeholder="tipo sanguíneo" ng-model="currentUser.currentMedicStatus.bloodType"/>
						</div>
					</div>
				</div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default btn-primary" data-dismiss="modal" ng-click="createOrAddPacient(currentUser)">Criar</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	        </div>
	      
	      </div>
	    </div>
 	</div>

</div>