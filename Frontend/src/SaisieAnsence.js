import axios from "axios";
import React from "react";
import { useState } from "react";
import { useEffect } from "react";
//import { Link } from "react-router-dom";
import Navbar from "./NavBar";
///const paperStyle = { padding: "50 px 20px", width: 600, margin: "20px auto" };

export default function SaisieAb() {
	const [timer, setTimer] = useState(false);
	const [message, setmessage] = useState("");
	const [listClass, setListClass] = useState([]);
	const [listModule, setListModule] = useState([]);
	const [listEt, setListEt] = useState([]);

	const [absence, setAbsence] = useState({
		idetudiant: "",
		presence: "",
		module: "",
		seance: "",
		seanceDate: "",
		semestre: 1,
		observation: "",
		classe: {
			id: "",
			nom: "",
		},
	});

	const handleChange = (e) => {
		setAbsence({ ...absence, [e.target.name]: e.target.value });
	};
	useEffect(() => {
		const getClass = async () => {
			await axios
				.get(`http://localhost:8084/classe/retrieve-all-classe`)
				.then((res) => {
					setListClass(res.data);
				})
				.catch((err) => {});
		};
		getClass();
		const getMod = async () => {
			await axios
				.get(`http://localhost:8084/absenceEtudiant/getAll`)
				.then((res) => {
					setListModule(res.data);
				})
				.catch((err) => {});
		};
		getMod();
		const getEtud = async () => {
			await axios
				.get(`http://localhost:8084/etudiant/retrieve-all-etudiant`)
				.then((res) => {
					setListEt(res.data);
				})
				.catch((err) => {
					console.log(err.message);
				});
		};
		getEtud();
	}, [absence]);

	const ajoutAbsence = async (e) => {
		e.preventDefault();
		console.log(absence);
		await axios
			.post(`http://localhost:8084/absenceEtudiant/add`, absence)
			.then((response) => {
				console.log("/*****Add Absence");
				setmessage(response.data);
				setTimer(true);
				setTimeout(() => {
					setTimer(false);
				}, 3000);
			})
			.catch((err) => {
				console.log(err.message);
				setmessage("errrrxcvxcvxcvcvvrrr");
				setTimer(true);
				setTimeout(() => {
					setTimer(false);
				}, 3000);
			});
	};
	return (
		<div>
			<Navbar />
			<div className="col-8">
				<h2
					style={{
						color: "red",
						textAlign: "center",
						marginTop: "3rem",
						marginLeft: "30rem",
					}}
				>
					Saisie Absence
				</h2>
			</div>
			<section className="container-fluid">
				{message && timer && (
					<div
						class="alert alert-outline-success "
						role="alert"
						style={{ borderColor: "black" }}
					>
						{message}
					</div>
				)}
				<div className="row">
					<div className="col-5">
						<form onSubmit={ajoutAbsence}>
							<div className="row">
								<div className="col-4">
									<label
										for="validationCustom01"
										class="form-label is-required"
									>
										Classes
									</label>
								</div>

								<div className="col-5">
									<div className="input-group">
										<select
											class="form-select"
											name="classe"
											value={absence.classe}
											onChange={handleChange}
										>
											<option>Séléctionner ....</option>
											{listClass.map((item, index) => (
												<option value={item.nom} key={index}>
													{item.nom}
												</option>
											))}
										</select>
									</div>
								</div>
							</div>
							<br />
							<div className="row">
								<div className="col-4">
									<label
										for="validationCustom01"
										class="form-label is-required"
									>
										Module
									</label>
								</div>
								<div className="col-5">
									<div className="input-group">
										<select
											class="form-select"
											name="module"
											value={absence.module}
											onChange={handleChange}
										>
											<option>Séléctionner ....</option>
											{listModule.map((item, index) => (
												<option value={item.module} key={index}>
													{item.module}
												</option>
											))}
										</select>
									</div>
								</div>
							</div>
							<br />
							<div className="row">
								<div className="col-4">
									<label
										for="validationCustom01"
										class="form-label is-required"
									>
										Séance
									</label>
								</div>
								<br />
								<div className="col-5">
									<div className="input-group">
										<div className="input-group">
											<select
												class="form-select"
												name="seance"
												value={absence.seance}
												onChange={handleChange}
											>
												<option>Séléctionner ....</option>
												<option>1: 09h:00 à 10h:30</option>
												<option>2: 10h:45 à 12h:15</option>
												<option>1: 13h:30 à 15h:30</option>
												<option>2: 15h:45 à 16h:45</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<br />
							<div className="row">
								<div className="col-4">
									<label
										for="validationCustom01"
										class="form-label is-required"
									>
										Date Séance
									</label>
								</div>
								<br />
								<div className="col-5">
									<div className="input-group">
										<div className="input-group">
											<input
												type="date"
												className="form-control"
												name="seanceDate"
												value={absence.seanceDate}
												onChange={handleChange}
											/>
										</div>
									</div>
								</div>
							</div>
							<br />
							<br />
							<div className="row">
								<div className="col-4">
									<button type="submit" class="btn btn-block   btn-success ">
										Enregistrer
									</button>
								</div>
								<div className="col-5">
									<button type="reset" class="btn btn-block btn-danger">
										Annuler
									</button>
								</div>
							</div>
							<br />
							<br />
							<div className="row">
								<div className="col-9">
									<button
										type="reset"
										class="btn btn-block btn"
										style={{ backgroundColor: "#a885d8" }}
									>
										Export Liste vers Excel
									</button>
								</div>
							</div>
						</form>{" "}
					</div>
					{/* /.card */}
					<div className="col-lg-7">
						<div className="card">
							<div className="card-body">
								<table className="table ">
									<thead>
										<tr>
											<th>ID_Etudient</th>
											<th>Nom et Prénom</th>
											<th>Absence</th>
											<th>Présence </th>
											<th>Justification</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										{listEt.map((item, index) => (
											<tr key={index}>
												<td>{item.idetudiant}</td>
												<td>
													{item.nom} {item.prenom}
												</td>
												<td>
													<input
														type="radio"
														name="presence"
														value={absence.presence}
														onChange={handleChange}
													/>
													Absent(e)
												</td>
												<td>
													<input
														type="radio"
														checked
														name="presence"
														value={absence.presence}
														onChange={handleChange}
													/>
													Présent(e)
												</td>
												<td>
													<input
														type="text"
														name="observation"
														value={absence.observation}
														onChange={handleChange}
													/>
												</td>
												<td>
													<a
														href="#modal-compte"
														data-bs-toggle="modal"
														className="btn btn-success"
													>
														<i className="fas fa-trash" />
													</a>
												</td>
											</tr>
										))}
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	);
}
