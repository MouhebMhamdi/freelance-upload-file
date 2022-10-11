import React from "react";

import Navbar from "./NavBar";
import { useAlert } from 'react-alert'
import axios from "axios";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
export default function UploadFile() {

	const [selectedFile, setSelectedFile] = React.useState(null);
	const alert = useAlert()
	const handleFileSelect = (event) => {
		setSelectedFile(event.target.files[0])
		console.log(event.target.files[0])
	  }

	const handleSubmit = async(event) => {
		console.log("submit")
		event.preventDefault()
		const formData = new FormData();
		formData.append("file", selectedFile);
		try {
		   await axios({
			method: "post",
			url: "http://localhost:8084/absenceEtudiant/file",
			data: formData,
			headers: { "Content-Type": "multipart/form-data" },
		  }).then((res) => {
			toast.success('File saved successfully !!')
		  });
		  
		} catch(error) {
		  console.log(error)
		}
	}
	return (
		<div>
			<ToastContainer />
			<Navbar />
			<section>
				<h2
					style={{
						color: "Red",
						marginLeft: "50px",
						marginTop: "20px",
					}}
				>
					Gestion des Absences
				</h2>

				<br />
				<div class="container-sm">
					{/* /.card-header */}
					<div className="card">
						<div className="col-9">
							<div
								className=" justify-content-center"
								style={{
									fontSize: "20px",
									marginTop: "5rem",
									marginLeft: "22rem",
								}}
							>
								<h1>Importer un fichier </h1>
								<br />
								<br />
								<div className="form-group">
			
								
								</div>
							

							<form onSubmit={handleSubmit}>
							<input type="file" onChange={handleFileSelect}/><br /><br /><br /><br />
								<div className="row">
									<div className="col-6">
										<div className="form-group">
											
											<button
												className="btn btn"
												type="submit"
												style={{ backgroundColor: "red" }}
											>
												Importer
											</button>
										</div>
									</div>
									<div className="col-4">
										<div className="form-group">
											<button
												className="btn btn-"
												type="submit"
												style={{ backgroundColor: "red" }}
											>
												Annuler
											</button>
										</div>
									</div>
								</div>
							</form>
							</div>
						</div>
					</div>{" "}
					<br />
				</div>
			</section>
		</div>
	);
}
