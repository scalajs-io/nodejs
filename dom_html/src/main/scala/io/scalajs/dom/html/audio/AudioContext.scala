package io.scalajs.dom.html.audio

import scala.scalajs.js

/**
  * The AudioContext interface represents an audio-processing graph built from audio modules linked together,
  * each represented by an AudioNode. An audio context controls both the creation of the nodes it contains and
  * the execution of the audio processing, or decoding. You need to create an AudioContext before you do anything
  * else, as everything happens inside a context.
  *
  * An AudioContext can be a target of events, therefore it implements the EventTarget interface.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class AudioContext extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a double representing an ever-increasing hardware time in seconds used for scheduling. It starts at 0.
    */
  def currentTime: Double = js.native

  /**
    * Returns an AudioDestinationNode representing the final destination of all audio in the context.
    * It can be thought of as the audio-rendering device.
    */
  def destination: AudioDestinationNode = js.native

  /**
    * Returns the AudioListener object, used for 3D spatialization.
    */
  var listener: js.Function = js.native

  /**
    * Returns a float representing the sample rate (in samples per second) used by all nodes in this context.
    * The sample-rate of an AudioContext cannot be changed.
    */
  def sampleRate: Double = js.native

  /**
    * Returns the current state of the AudioContext.
    */
  def state: Int = js.native

  /**
    * Used to return the audio channel that the sound playing in an AudioContext will play in, on a Firefox OS device.
    */
  def mozAudioChannelType: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Event Listener
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * An event handler that runs when an event of type statechange has fired. This occurs when the AudioContext's
    * state changes, due to the calling of one of the state change methods (AudioContext.suspend, AudioContext.resume,
    * or AudioContext.close).
    * @return
    */
  def onstatechange: js.Function = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Closes the audio context, releasing any system audio resources that it uses.
    */
  def close(): Unit = js.native

  /**
    * Creates a new, empty AudioBuffer object, which can then be populated by data and played via an AudioBufferSourceNode.
    */
  def createBuffer(): AudioBuffer = js.native

  /**
    * Creates a ConstantSourceNode object, which is an audio source that continuously outputs a monaural (one-channel)
    * sound signal whose samples all have the same value.
    */
  def createConstantSource(): ConstantSourceNode = js.native

  /**
    * Creates an AudioBufferSourceNode, which can be used to play and manipulate audio data contained within an
    * AudioBuffer object. AudioBuffers are created using AudioContext.createBuffer or returned by
    * AudioContext.decodeAudioData when it successfully decodes an audio track.
    */
  def createBufferSource(): AudioBufferSourceNode = js.native

  /**
    * Creates a MediaElementAudioSourceNode associated with an HTMLMediaElement. This can be used to play and
    * manipulate audio from <video> or <audio> elements.
    */
  def createMediaElementSource(): MediaElementAudioSourceNode = js.native

  /**
    * Creates a MediaStreamAudioSourceNode associated with a MediaStream representing an audio stream which may come
    * from the local computer microphone or other sources.
    */
  def createMediaStreamSource(): MediaStreamAudioSourceNode = js.native

  /**
    * Creates a MediaStreamAudioDestinationNode associated with a MediaStream representing an audio stream which
    * may be stored in a local file or sent to another computer.
    */
  def createMediaStreamDestination(): MediaStreamAudioDestinationNode = js.native

  /**
    * Creates a ScriptProcessorNode, which can be used for direct audio processing via JavaScript.
    */
  def createScriptProcessor(): ScriptProcessorNode = js.native

  /**
    * Creates a StereoPannerNode, which can be used to apply stereo panning to an audio source.
    */
  def createStereoPanner(): StereoPannerNode = js.native

  /**
    * Creates an AnalyserNode, which can be used to expose audio time and frequency data and for example to create
    * data visualisations.
    */
  def createAnalyser(): AnalyserNode = js.native

  /**
    * Creates a BiquadFilterNode, which represents a second order filter configurable as several different common
    * filter types: high-pass, low-pass, band-pass, etc.
    */
  def createBiquadFilter(): BiquadFilterNode = js.native

  /**
    * Creates a ChannelMergerNode, which is used to combine channels from multiple audio streams into a single audio stream.
    */
  def createChannelMerger(): ChannelMergerNode = js.native

  /**
    * Creates a ChannelSplitterNode, which is used to access the individual channels of an audio stream and process them separately.
    */
  def createChannelSplitter(): ChannelSplitterNode = js.native

  /**
    * Creates a ConvolverNode, which can be used to apply convolution effects to your audio graph, for example a reverberation effect.
    */
  def createConvolver(): ConvolverNode = js.native

  /**
    * Creates a DelayNode, which is used to delay the incoming audio signal by a certain amount. This node is also useful to create feedback loops in a Web Audio API graph.
    */
  def createDelay(): DelayNode = js.native

  /**
    * Creates a DynamicsCompressorNode, which can be used to apply acoustic compression to an audio signal.
    */
  def createDynamicsCompressor(): DynamicsCompressorNode = js.native

  /**
    * Creates a GainNode, which can be used to control the overall volume of the audio graph.
    */
  def createGain(): GainNode = js.native

  /**
    * Creates an IIRFilterNode, which represents a second order filter configurable as several different common filter types.
    */
  def createIIRFilter(): IIRFilterNode = js.native

  /**
    * Creates an OscillatorNode, a source representing a periodic waveform. It basically generates a tone.
    */
  def createOscillator(): OscillatorNode = js.native

  /**
    * Creates a PannerNode, which is used to spatialise an incoming audio stream in 3D space.
    */
  def createPanner(): PannerNode = js.native

  /**
    * Creates a PeriodicWave, used to define a periodic waveform that can be used to determine the output of an OscillatorNode.
    */
  def createPeriodicWave(): PeriodicWave = js.native

  /**
    * Creates a WaveShaperNode, which is used to implement non-linear distortion effects.
    */
  def createWaveShaper(): WaveShaperNode = js.native

  /**
    * Creates an AudioWorkerNode, which can interact with a web worker thread to generate, process, or analyse audio
    * directly. This was added to the spec on August 29 2014, and is not implemented in any browser yet.
    */
  def createAudioWorker(): AudioWorkerNode = js.native

  /**
    * Asynchronously decodes audio file data contained in an ArrayBuffer. In this case, the ArrayBuffer is usually
    * loaded from an XMLHttpRequest's response attribute after setting the responseType to arraybuffer. This method
    * only works on complete files, not fragments of audio files.
    */
  def decodeAudioData(): Unit = js.native

  /**
    * Resumes the progression of time in an audio context that has previously been suspended.
    */
  def resume(): Unit = js.native

  /**
    * Suspends the progression of time in the audio context, temporarily halting audio hardware access and reducing CPU/battery usage in the process.
    */
  def suspend(): Unit = js.native

}
