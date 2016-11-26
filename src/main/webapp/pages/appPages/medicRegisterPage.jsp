<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8"%>

<div ng-controller="medicRegisterCtrl">
	<section class="section-main-page">
		
		<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text mdl-shadow--4dp">
			<h5 class="card-title">
				Consultar

				<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" style="float: right" ng-show="!searchPanelVisible"  ng-click = "searchPanelVisible = !searchPanelVisible"><i class="material-icons">keyboard_arrow_down</i></button>
				<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" style="float: right" ng-show="searchPanelVisible"  ng-click = "searchPanelVisible = !searchPanelVisible"><i class="material-icons">keyboard_arrow_left</i></button>
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
				<div class="container">
					<div class="col-md-4">
						<h5>{{pacient.completeName}}</h5>
					</div>
				</div>
			</div>		
		</div>

			
	</section>

	<div class = container>
		<div class="row">
				
			<div ng-repeat="register in registers" class="mdl-card mdl-card__supporting-text mdl-shadow--2dp list-card">
				<div>
					<div class="row-list-title">
						<span class="list-card-title">{{register.description}}</span> 
					</div>
					
					<div class="row-list-buttons">
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">create</i></button>
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" ng-click="delete(user)"><i class="material-icons">delete</i></button>
					</div>
				</div>
			</div>
		
		</div>
	</div>
</div>