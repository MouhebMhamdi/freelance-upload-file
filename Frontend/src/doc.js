import React from "react";
//import { Link } from "react-router-dom";
import Navbar from "./NavBar";

export default function UploadFile() {
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
				<div style={{ margin: "50px" }}>
					<table className="table table-hover">
						<thead color="red">
							<tr>
								<th>Date scéance </th>
								<th>N° scéance</th>
								<th>Séance</th>
								<th>Module</th>
								<th>Justification</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>222222222</td>
								<td>prenom</td>
								<td>nom</td>
								<td>prenom</td>
								<td>oui/non</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	);
}
