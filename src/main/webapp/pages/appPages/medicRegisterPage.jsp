<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8"%>

<div ng-controller="medicRegisterCtrl">
	<div class="main-container">
		<div class="container">
			<div class="mdl-layout__tab-panel is-active">
	
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<section>
								
								<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text mdl-shadow--4dp">
									<h5>
										Consultar

										<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" style="float: right" ng-show="!searchPanelVisible"  ng-click = "searchPanelVisible = !searchPanelVisible"><i class="material-icons">keyboard_arrow_down</i></button>
										<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" style="float: right" ng-show="searchPanelVisible"  ng-click = "searchPanelVisible = !searchPanelVisible"><i class="material-icons">keyboard_arrow_up</i></button>
									</h5>
								
									<div ng-show="searchPanelVisible">					
										<div class="container mdl-card-container">
											<div class="row">
												<div class="col-md-4">
													<select ng-options="optionParam.name for optionParam in selectionParams" ng-model="optionParam" style="width:100%!" ng-change="setSelectionParam(optionParam)">
														<option value="">Escolha uma opção para a busca</option>
													</select>
												</div>

												<div class="col-md-4" >
													<input ng-model="paramSearchValue" type="text" style="width:100%" ng-show="currentSelectionParam == 1" placeholder="CPF"/>
													<input ng-model="paramSearchValue" type="text" style="width:100%" ng-show="currentSelectionParam == 2" placeholder="RG"/>
													<input ng-model="paramSearchValue" type="text" style="width:100%" ng-show="currentSelectionParam == 3" placeholder="CNS"/>
												</div>

												<div class="col-md-4">
													<button style="width:100%" class="btn btn-primary" ng-click="getPacientRegisters()">Consultar</button>
												</div>
											</div>
										</div>
									</div>

									<div ng-if="pacient">
										<h4 class="card-title">Paciente</h4>
										<div class="container" style="width:100%">
											<div class="row">
												<div class="col-md-4">
													<h5>Nome:{{pacient.completeName}}</h5>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-4">
													<h5>Sangue:{{pacient.currentMedicStatus.bloodType}}</h5>
												</div>

												<div class="col-md-4">
													<h5>Altura:{{pacient.currentMedicStatus.height}} m</h5>
												</div>

												<div class="col-md-4">
													<h5>peso:{{pacient.currentMedicStatus.weight}} kg</h5>
												</div>
											</div>
										
											<div class="row">
												<div class="col-md-6">
													<h5>Gênero:{{pacient.genre}}</h5>
												</div>

												<div class="col-md-6">
													<h5>Idade:{{pacient.age}}</h5>
												</div>
											</div>
										</div>
									</div>		
								</div>
									
							</section>

							<section>
								
								<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text mdl-shadow--4dp">
									
								</div>
							
							</section>
						</div>

						<div class="col-md-6">

							<div class = "container" style="width:100%">
								<div class="row">
										
									<div ng-repeat="register in registers" class="mdl-card mdl-card__supporting-text mdl-shadow--2dp list-card">
										<div>
											<div class="row-list-title">
												<span class="list-card-title">{{register.description}}</span> 
											</div>
											
											<div class="row-list-buttons">
												<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">create</i></button>
											</div>
										</div>
									</div>
								
								</div>
							</div>
						
						</div>
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
</div>