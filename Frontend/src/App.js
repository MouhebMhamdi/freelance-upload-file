import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./NavBar";
import ImportAbcense from "./ImportAbsence";
import SuiviAbsence from "./SuiviAnsence";
import SaisieAbsence from "./SaisieAnsence";
function App() {
	return (
		<div className="App">
			<Router>
				<Routes>
					<Route path="/home" element={<Home />}></Route>
					<Route path="/importAbcense" element={<ImportAbcense />}></Route>
					<Route path="/suiviAbsence" element={<SuiviAbsence />}></Route>
					<Route path="/saisieAbsence" element={<SaisieAbsence />}></Route>
				</Routes>
			</Router>
		</div>
	);
}

export default App;
