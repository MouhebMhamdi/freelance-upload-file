import React from "react";
import { Link } from "react-router-dom";

//import { logout } from "../../redux/action/candidatAction";
import Logo from "./espritLogo.jpg";
export default function Navbar() {
	// const dispatch = useDispatch();
	// const navigate = useNavigate();

	return (
		<div>
			<nav className="navbar navbar-expand-lg navbar-dark bg-dark">
				<div className="container-fluid">
					<div className="navbar-brand">
						<img src={Logo} width={350} height={250} alt="Boosted" />
					</div>
					<button
						className="navbar-toggler"
						type="button"
						data-bs-toggle="collapse"
						data-bs-target="rrnavbarSupportedContent"
						aria-controls="navbarSupportedContent"
						aria-expanded="false"
						aria-label="Toggle navigation"
					>
						<span className="navbar-toggler-icon" />
					</button>
					<div
						className="collapse navbar-collapse align-items-end"
						id="navbarSupportedContent"
					>
						<ul className="navbar-nav me-auto">
							<li className="nav-item">
								<Link to="/Home" className="nav-link " aria-current="page">
									Home
								</Link>
							</li>
							<li className="nav-item">
								<Link to="" className="nav-link">
									Link
								</Link>
							</li>
							<li className="nav-item dropdown">
								<Link
									className="nav-link dropdown-toggle"
									role="button"
									data-bs-toggle="dropdown"
									aria-expanded="false"
								>
									Absence
								</Link>
								<ul className="dropdown-menu">
									<li>
										<Link to="/importAbcense" className="dropdown-item">
											Import Absence
										</Link>
									</li>
									<li>
										<Link to="/saisieAbsence" className="dropdown-item">
											Saisie Absence
										</Link>
									</li>
									<li>
										<Link to="/suiviAbsence" className="dropdown-item">
											Suivi Absence
										</Link>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	);
}
