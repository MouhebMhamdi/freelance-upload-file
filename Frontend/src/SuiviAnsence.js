import { CircularProgress } from "@material-ui/core";
import axios from "axios";
import React, { useEffect, useState } from "react";
//import { Link } from "react-router-dom";
import Navbar from "./NavBar";

export default function Suivi() {
	// axios
	// .get("http://localhost:8084/absenceEtudiant/getAll")
	// .then((res) => {
	// 	console.log("get all data from ab", res); //semfony dump()
	// 	setListAb(res.data);
	// 	setLoading(false);
	// })
	// .catch((err) => {
	// 	console.log(err.message);
	// 	setLoading(false);
	// });
	const [listeAb, setListAb] = useState([]);
	const [loading, setLoading] = useState(true);
	useEffect(() => {
		const getAll = async () => {
			console.log("/****get All absence : ");
			await axios
				.get(`http://localhost:8084/absenceEtudiant/getAll`)
				.then((response) => {
					console.log("/***** Get All abc ******/", response.data);
					setListAb(response.data); //n3abi array liste l lfou9 f const
					setLoading(false);
				})
				.catch((err) => {
					console.log(err);
					setLoading(false);
				});
		};
		getAll();
	}, []);
	return (
		<div>
			<Navbar />
			<div className="col-8">
				<h2
					style={{
						color: "red",
						textAlign: "center",
						marginTop: "5rem",
						marginLeft: "30rem",
					}}
				>
					Absence
				</h2>
			</div>
			<section className="content">
				{loading ? (
					<div class="position-relative" style={{ marginTop: "20rem" }}>
						<div class="position-absolute top-50 start-50 translate-middle">
							<div class="spinner-border  spinner-border-lg" role="status">
								<span class="visually-hidden">
									<CircularProgress />
								</span>
							</div>
						</div>
					</div>
				) : (
					<div style={{ margin: "50px" }}>
						<table className="table table-hover">
							<thead color="red">
								<tr>
									<th>Date scéance </th>
									<th>N° scéance</th>
									<th>Module</th>
									<th>Justification</th>
								</tr>
							</thead>
							<tbody>
								{listeAb.map((item, index) => {
									return (
										<tr key={index}>
											<td>{item.seanceDate}</td>
											<td>{item.seance}</td>
											<td>{item.module}</td>
											<td>{item.observation}</td>
										</tr>
									);
								})}
							</tbody>
						</table>
					</div>
				)}
			</section>
		</div>
	);
}
